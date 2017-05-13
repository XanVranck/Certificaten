import { klantenComponent } from './klanten/klanten.component';


export const routes = [
    { path: '', redirectTo:'klanten', pathMatch: 'full'},
    { path: 'klanten', component: klantenComponent},
];