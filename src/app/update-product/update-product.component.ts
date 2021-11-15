import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  product :Product = new Product();
  constructor(private productService:ProductServiceService,
    private route:ActivatedRoute,
    private router:Router) { }

  id:number | any;
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.productService.getProductById(this.id).subscribe(data => {
      this.product =  data; 
    })
  }

  onSubmit(){
    this.productService.updateProduct(this.id,this.product).subscribe(data =>{
     this.goToProductList();
    },error =>  console.log(error));      
   }

   goToProductList(){
     this.router.navigate(['/product']);
   }

}
