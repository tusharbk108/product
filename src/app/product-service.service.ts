import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';
@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  private baseURL = "http://localhost:8080/products";
  constructor(private httpClient:HttpClient) { }

  getProductList() : Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseURL}`);
  }

  addProduct(product:Product):Observable<object>{
    return this.httpClient.post(`${this.baseURL}`,product);
  }

  getProductById(id:number):Observable<Product>{
    return this.httpClient.get<Product>(`${this.baseURL}/${id}`);
  }

  updateProduct(id:number,product:Product):Observable<Object>{
    return this.httpClient.put<Product>(`${this.baseURL}/${id}`,product);
  }

  deleteProduct(id:number):Observable<Object>{
    return this.httpClient.delete<Product>(`${this.baseURL}/${id}`);
  }
}
