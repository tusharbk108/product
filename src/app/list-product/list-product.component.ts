import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  product : Product[] = [];
  constructor(private productService : ProductServiceService,
    private router:Router) { }

  ngOnInit(): void {
    
    this.getProduct();
  }

  getProduct(){
    this.productService.getProductList().subscribe(data =>{
      this.product = data;
    })
  }

  updateProduct(id:number){
      this.router.navigate(['/update-product',id])
  }

  deleteProduct(id:number){
    this.productService.deleteProduct(id).subscribe(data =>{
      console.log(data);
      this.getProduct();
    })
  }
  

}
