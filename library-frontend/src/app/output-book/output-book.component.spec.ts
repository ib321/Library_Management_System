import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutputBookComponent } from './output-book.component';

describe('OutputBookComponent', () => {
  let component: OutputBookComponent;
  let fixture: ComponentFixture<OutputBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutputBookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutputBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
