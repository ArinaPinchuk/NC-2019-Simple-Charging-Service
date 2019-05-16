import {NgModule} from "@angular/core";

import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {SignupPageComponent} from "./signup-page.component";

@NgModule({
  declarations: [
    SignupPageComponent,
  ],
  imports: [
    ReactiveFormsModule
  ],
  providers: [],
  exports: [SignupPageComponent]
})
export class AccountModule {
}
