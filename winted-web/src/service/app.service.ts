import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Cookie } from 'ng2-cookies';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  public clientId = environment.oauth2_client_id;
  public redirectUri = environment.oauth2_redirect_url + '/';
  public clientSecret = environment.oauth2_client_secret;
  public asUrl = environment.as_url;

  constructor(private _http: HttpClient) {}

  retrieveToken(code) {
    console.log('code ', code);
    let params = new URLSearchParams();
    params.append('grant_type', 'authorization_code');
    params.append('client_id', this.clientId);
    params.append('client_secret', this.clientSecret);
    params.append('redirect_uri', this.redirectUri);
    params.append('code', code);

    let headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
    });

    this._http
      .post(
        this.asUrl + '/realms/winted/protocol/openid-connect/token',
        params.toString(),
        { headers: headers }
      )
      .subscribe(
        (data) => this.saveToken(data),
        (err) => alert('Invalid Credentials')
      );
  }

  saveToken(token) {
    var expireDate = new Date().getTime() + 1000 * token.expires_in;
    Cookie.set('access_token', token.access_token, expireDate);
    console.log('Obtained Access token');
    window.location.href = this.redirectUri;
  }

  getResource(resourceUrl): Observable<any> {
    var headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      Authorization: 'Bearer ' + Cookie.get('access_token'),
    });

    return this._http
      .get(resourceUrl, { headers: headers })
      .pipe(
        catchError((error: any) =>
          throwError(() => error.json().error || 'Server error')
        )
      );
  }

  checkCredentials() {
    return Cookie.check('access_token');
  }

  logout() {
    Cookie.delete('access_token');
    window.location.reload();
  }
}
