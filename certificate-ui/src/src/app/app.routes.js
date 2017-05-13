"use strict";
var home_component_1 = require('./home/home.component');
var klanten_component_1 = require('../app/klanten/klanten.component');
exports.routes = [
    { path: '', component:klanten_component_1, pathMatch: 'full' },
    { path: 'klanten', component: klanten_component_1.klantenComponent}
];
