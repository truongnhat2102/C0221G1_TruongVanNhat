import {Component, Inject, OnInit, Output} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {FormControl, FormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";

// import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  product: Product;



  // constructor(private productService: ProductService, private modalService: NgbModal) {
  // }
  constructor(private productService: ProductService, public dialog: MatDialog) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

  // showFormEdit(id: number) {
  //   this.productService.getProduct(id)
  //   this.product = this.productService.productService;
  //   console.log(this.product);
  // }



  openDialog(id: number): void {
    this.productService.getProduct(id);
    this.product = this.productService.productService;
    console.log(this.product);
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: {
        id: this.product.id,
        name: this.product.name,
        price: this.product.price,
        description: this.product.description
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.product = result;
    });
  }

  deleteProduct(id: number) {

  }

  // open(id: number) {
  //   this.productService.getProduct(id);
  //   this.product = this.productService.productService;
  //   console.log(this.product);
  //   this.modalService.open(id, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
  //     this.closeResult = `Closed with: ${result}`;
  //   }, (reason) => {
  //     this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  //   });
  // }
  //
  // private getDismissReason(reason: any): string {
  //   if (reason === ModalDismissReasons.ESC) {
  //     return 'by pressing ESC';
  //   } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
  //     return 'by clicking on a backdrop';
  //   } else {
  //     return `with: ${reason}`;
  //   }
  // }
}

@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: 'dialog-overview-example-dialog.html',
})
export class DialogOverviewExampleDialog {

  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: Product, private productService: ProductService) {
  }

  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });

  editProduct() {
    this.productService.editProduct(this.productForm.value.id);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
