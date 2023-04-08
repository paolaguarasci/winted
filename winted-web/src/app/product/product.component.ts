import { Component, OnInit } from '@angular/core';

import { AppService } from 'src/service/app.service';
import { Product } from 'src/model/Product';
import { environment } from 'src/environments';

@Component({
  selector: 'product-details',
  templateUrl: './product.component.html',
  providers: [AppService],
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  public product = new Product(
    '57361225-26ac-46cc-a2c4-07c81f50f1f8',
    'sample product',
    'sample desc'
  );
  private productsUrl = environment.rs_url + '/api/products/';

  constructor(private _service: AppService) {}

  ngOnInit() {
    console.log('Ciao');
  }

  getProduct() {
    this._service.getResource(this.productsUrl + this.product.id).subscribe(
      (data) => (this.product = data),
      (error) => (this.product.title = 'Error')
    );
  }
}
