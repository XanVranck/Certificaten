import { klantenComponent } from './klanten/klanten.component';
import { ordersComponent } from './orders/orders.component';



export const routes = [
    { path: '', redirectTo:'klanten', pathMatch: 'full'},
    { path: 'klanten', component: klantenComponent},
    { path: 'orders', component: ordersComponent},
];