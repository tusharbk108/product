import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  product :Product = new Product();
  constructor(private productService:ProductServiceService,
    private router:Router) { }

  ngOnInit(): void {
  }

  saveProduct(){
    this.productService.addProduct(this.product).subscribe(data =>{
      console.log(data);
      this.goToProductList();
    },
    error => console.error(error));
  }

  goToProductList(){
    this.router.navigate(['/product']);
  }
  onSubmit(){
    console.log(this.product);
    this.saveProduct();
  }

}
