import {Component} from '@angular/core';

@Component({
    selector: 'klanten',
    template: `
        <div class="wrapper">
            <h2>Choose existing customer</h2>
            <form method="post" action="order.html" class="ccform">
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-users fa-2x"></i></span>
                    <input list="customers" name="customer" class="ccformfield" required>
                    <datalist id="customers">
                        <option value="Customer 1">
                        <option value="Customer 2">
                        <option value="Customer 3">
                        <option value="Customer 4">
                        <option value="Customer 5">
                    </datalist>
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" value="Submit">
                </div>
            </form>


            <h2>Add customer</h2>
            <form method="post" action="127.0.0.1:9000/klant" class="ccform">
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-user-plus fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Full Name" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-id-card-o fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Street" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-sort-numeric-asc fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Housenumber" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-info fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="ZIP" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-building fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="city" required>
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" value="Submit">
                </div>
            </form>
        </div>
    `
})

export class klantenComponent {

}
