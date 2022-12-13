import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { SwitchService } from '../../../../services/switch.service';

@Component({
  selector: 'modal-new-entry',
  templateUrl: './modal-new-entry.component.html',
  styleUrls: ['./modal-new-entry.component.css']
})
export class ModalNewEntryComponent implements OnInit {
  model: NgbDateStruct | undefined;
  checkedDefault: boolean = true;
  //newEntry: FormGroup;

  categories = [
    {
      title: "Servicios"
    },
    {
      title: "Estudio"
    },
    {
      title: "Alimentación"
    },
    {
      title: "Salud"
    },
    {
      title: "transporte"
    },
    {
      title: "Ocio"
    },
    {
      title: "Otro"
    },
  ]

  constructor(private formBuilder:FormBuilder,
              private modalService: SwitchService) {

    /* this.newEntry = this.formBuilder.group(
      {
        title: ['', [Validators.minLength(6),Validators.maxLength(30)]],
      }) */
  }

  ngOnInit(): void {
  }

  selectCategory: number = 0;

  categorySelect(i: number) {

    this.selectCategory = i;
  }

  closeModal() {
    this.modalService.$modal.emit(false)
  }
}
