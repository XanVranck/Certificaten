import {Router} from "@angular/router";
import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'orders',
    template: `
<header class="ccheader">
    <h1>Orders</h1>	
</header>
<div class="wrapper">
<h2>Choose existing order</h2>
    <table class="ccform">
     <thead>
         <tr>
             <th>Workorder nr</th>
             <th>Purchase order nr</th>
             <th>Specification</th>
             <th>Estimated</th>
         </tr>
     </thead>
     <tbody>
     <form method="post" action="certificates.html">
         <tr>
             <td>
                 <div class="radio">
                     <label><input type="radio" id='workorder1' name="workorder" required>Workorder 1</label>
                 </div>
             </td>
             <td>
             <div class="radiotext">
                 <label for='workorder1'>Purchaseorder1</label>
             </div>
             </td>
            <td>
             <div class="radiotext">
                 <label for='workorder1'>Specificatie1</label>
             </div>
             </td>
              <td>
             <div class="radiotext">
                 <label for='workorder1'>Total estimated1</label>
             </div>
             </td>
         </tr>
          <tr>
             <td>
                 <div class="radio">
                     <label><input type="radio" id='workorder2' name="workorder">Workorder 2</label>
                 </div>
             </td>
             <td>
             <div class="radiotext">
                 <label for='workorder2'>Purchaseorder2</label>
             </div>
             </td>
            <td>
             <div class="radiotext">
                 <label for='workorder2'>Specificatie2</label>
             </div>
             </td>
              <td>
             <div class="radiotext">
                 <label for='workorder2'>Total estimated2</label>
             </div>
             </td>
         </tr>
           <tr>
             <td>
                 <div class="radio">
                     <label><input type="radio" id='workorder3' name="workorder">Workorder 3</label>
                 </div>
             </td>
             <td>
             <div class="radiotext">
                 <label for='workorder3'>Purchaseorder3</label>
             </div>
             </td>
            <td>
             <div class="radiotext">
                 <label for='workorder3'>Specificatie3</label>
             </div>
             </td>
              <td>
             <div class="radiotext">
                 <label for='workorder3'>Total estimated3</label>
             </div>
             </td>
         </tr>
           <tr>
             <td>
                 <div class="radio">
                     <label><input type="radio" id='workorder4' name="workorder">Workorder 4</label>
                 </div>
             </td>
             <td>
             <div class="radiotext">
                 <label for='workorder4'>Purchaseorder4</label>
             </div>
             </td>
            <td>
             <div class="radiotext">
                 <label for='workorder4'>Specificatie4</label>
             </div>
             </td>
              <td>
             <div class="radiotext">
                 <label for='workorder4'>Total estimated4</label>
             </div>
             </td>
         </tr>
         <tr class="">
         <td style="align:right;"><input class="ccbtn" type="submit" value="Submit" ></td>
         <td></td>
         <td></td>
         <td></td>
        
    </tr>
         </form>
         
         </tbody>
</table>
    
    
    
	<h2>Add new order</h2>
    <form method="post" action="" class="ccform">
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-plus-circle fa-2x"></i></span>
        <input class="ccformfield" type="text" placeholder="Work order nr" required>
    </div>
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-tasks fa-2x"></i></span>
        <input class="ccformfield" type="text" placeholder="Purchase order nr" required>
    </div>
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-server fa-2x"></i></span>
        <input class="ccformfield" type="text" placeholder="Specification" required>
    </div>
     <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-calculator fa-2x"></i></span>
        <input class="ccformfield" type="text" placeholder="Total estimated" required>
    </div>
    <div class="ccfield-prepend">
        <input class="ccbtn" type="submit" value="Submit">
    </div>
    </form>
</div>
`
})

export class ordersComponent implements OnInit {
        ngOnInit(){

    }
}