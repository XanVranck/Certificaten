import { klantenComponent } from './klanten/klanten.component';
import { ordersComponent } from './orders/orders.component';
import { certificatenComponent } from './certificaten/certificaten.component';




export const routes = [
    { path: '', redirectTo:'klanten', pathMatch: 'full'},
    { path: 'klanten', component: klantenComponent},
    { path: 'orders', component: ordersComponent},
    { path: 'certificaten', component: certificatenComponent},    
];