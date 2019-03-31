import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EWalletPageComponent } from './e-wallet-page.component';

describe('EWalletPageComponent', () => {
  let component: EWalletPageComponent;
  let fixture: ComponentFixture<EWalletPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EWalletPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EWalletPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
