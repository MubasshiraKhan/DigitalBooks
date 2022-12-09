import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UserformComponent } from './userform/userform.component';
import { OrderformComponent } from './orderform/orderform.component';
import { HttpClientModule } from "@angular/common/http";
import { EllipsisPipe } from './ellipsis.pipe';
import { Route, RouterModule } from '@angular/router';

const routes: Route[] = [
  { path: 'userform', component: UserformComponent }
]
@NgModule({//decorator
  declarations: [
    AppComponent,
    UserformComponent,
    OrderformComponent,
    EllipsisPipe
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }