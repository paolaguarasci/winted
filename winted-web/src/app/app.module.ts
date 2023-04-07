import {
  HttpClient,
  HttpClientModule,
} from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, ProductComponent],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule],
  providers: [HttpClient],
  bootstrap: [AppComponent],
})
export class AppModule {}
