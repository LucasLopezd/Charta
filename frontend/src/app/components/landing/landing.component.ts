import { Component, OnInit } from '@angular/core';
import { AboudUSService } from './services/aboud-us.service';
import { AboudUs } from './models/aboudUS';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  listaParticipantes: any=[];
  listaParticipantes2 = [
    
  {
      "id": 61,
      "nameComplete": "Lucas Martín González",
      "role": "Backend Developer",
      "description": "Forma parte del equipo de back con java y spring boot",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/lucas-g-perfil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvbHVjYXMtZy1wZXJmaWwuanBlZyIsInRyYW5zZm9ybWF0aW9ucyI6IiIsImlhdCI6MTY3MDM2MDU5NSwiZXhwIjoxOTg1NzIwNTk1fQ.ZMcV3ot-OYMrJ7C5LM8oyuIMR4jlcTo9AxIQzj90lo4&t=2022-12-06T21%3A03%3A15.072Z",
      "linkedIn": "https://www.linkedin.com/in/lucasmartingonzalez/",
      "behance": null,
      "github": null,
      "email": ""
  },
  {
      "id": 62,
      "nameComplete": "Carolina Villa",
      "role": "Diseñadora UX/UI",
      "description": "Lead del research y de la creación de wireframes y prototipado",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/carolina-perfil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvY2Fyb2xpbmEtcGVyZmlsLmpwZWciLCJ0cmFuc2Zvcm1hdGlvbnMiOiIiLCJpYXQiOjE2NzAzNjA2MDYsImV4cCI6MTk4NTcyMDYwNn0.joDK-oz41u02bPHZP6aBqFQycVL7OLHPOXeGykyqgT4",
      "linkedIn": "https://www.linkedin.com/in/carolina--villa",
      "behance": "https://www.behance.net/carolinavilla2?tracking_source=search_users|Carolina%20villa",
      "github": null,
      "email": ""
  },
  {
      "id": 59,
      "nameComplete": "Leonel Perez",
      "role": "Frontend Developer",
      "description": "Forma parte del equipo de front con angular y bootstrap",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/leonel-perfil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvbGVvbmVsLXBlcmZpbC5qcGVnIiwidHJhbnNmb3JtYXRpb25zIjoiIiwiaWF0IjoxNjcwMzYwNTY4LCJleHAiOjE5ODU3MjA1Njh9.gqohhr3m9csb92RJds3N8iSUsYfr6uMQzVnR_8RLehE&t=2022-12-06T21%3A02%3A47.348Z",
      "linkedIn": "https://www.linkedin.com/in/leonelpb/",
      "behance": null,
      "github": "https://github.com/leonelpb",
      "email": ""
  },
  {
      "id": 64,
      "nameComplete": "Santiago Castellani",
      "role": "Frontend Developer",
      "description": "Forma parte del equipo de front con angular y bootstrap.",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/santiago-perfil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvc2FudGlhZ28tcGVyZmlsLmpwZWciLCJ0cmFuc2Zvcm1hdGlvbnMiOiIiLCJpYXQiOjE2NzAzNjA2NDEsImV4cCI6MTk4NTcyMDY0MX0.WpkjOC8-9UAq9_6f8DfBq-qI1ATKTsbr0Y1iDoLpJJs",
      "linkedIn": "https://www.linkedin.com/in/santiagocastellani/",
      "behance": null,
      "github": "https://github.com/SantiagoCastellani",
      "email": ""
  },
  {
      "id": 67,
      "nameComplete": "Laureana Broccolli",
      "role": "Devops",
      "description": "Encargada de automatizar la app mediante el deploy",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/laureana-perfil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvbGF1cmVhbmEtcGVyZmlsLmpwZWciLCJ0cmFuc2Zvcm1hdGlvbnMiOiIiLCJpYXQiOjE2NzAzNjA2ODcsImV4cCI6MTk4NTcyMDY4N30.s7fuxpHhADplq3opyzpHDX5yzH9sgCb02zMHAOCWwhY&t=2022-12-06T21%3A04%3A46.880Z",
      "linkedIn": "https://www.linkedin.com/in/laureana-broccolli-828460187/",
      "behance": null,
      "github": "https://github.com/laureanabroccolli",
      "email": ""
  },
  {
      "id": 60,
      "nameComplete": "Lucas Ariel López Delgado",
      "role": "Backend Developer",
      "description": "Forma parte del equipo de back con java y spring boot",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/lucas-l-pefil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvbHVjYXMtbC1wZWZpbC5qcGVnIiwidHJhbnNmb3JtYXRpb25zIjoiIiwiaWF0IjoxNjcwMzYwNTgxLCJleHAiOjE5ODU3MjA1ODF9.ce6R3x_C8t60W9sc4ESCFzbdqhFGRkx7Qlv2ivPNktM",
      "linkedIn": "https://www.linkedin.com/in/lucas-l%C3%B3pez-delgado/",
      "behance": null,
      "github": "https://github.com/LucasLopezd",
      "email": ""
  },
  {
      "id": 63,
      "nameComplete": "Damián Sformo",
      "role": "Backend Developer",
      "description": "Forma parte del equipo de back con java y spring boot",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/damian-perfil.jpg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvZGFtaWFuLXBlcmZpbC5qcGciLCJ0cmFuc2Zvcm1hdGlvbnMiOiIiLCJpYXQiOjE2NzAzNjA2MTksImV4cCI6MTk4NTcyMDYxOX0.kp2PR6csNBziTC5yhH25IkdhyR0mC4ESbcolDtB8vUg",
      "linkedIn": "https://www.linkedin.com/in/dami%C3%A1n-sformo-219341120/",
      "behance": null,
      "github": "https://github.com/DamianSformo",
      "email": ""
  },
  {
      "id": 66,
      "nameComplete": "Ivana Gisel Azcona",
      "role": "Analista QA",
      "description": "Encargada de la calidad del proyecto en todas sus faces",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/ivana-perfil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvaXZhbmEtcGVyZmlsLmpwZWciLCJ0cmFuc2Zvcm1hdGlvbnMiOiIiLCJpYXQiOjE2NzAzNjA2NjgsImV4cCI6MTk4NTcyMDY2OH0.W2pSrWzgM_iPV1Sg4tI5vAO-l-EsPCu5vnS_EyM2AVU",
      "linkedIn": "https://www.linkedin.com/in/ivana-gisel-azcona-67a331229",
      "behance": null,
      "github": null,
      "email": ""
  },
  {
      "id": 65,
      "nameComplete": "Alexis Estrada Evangelista",
      "role": "Frontend Developer",
      "description": "Forma parte del equipo de front con angular y bootstrap.",
      "image": "https://niocqzxypzutwctzuyfj.supabase.co/storage/v1/object/sign/bucketcharta/alex-perfil.jpeg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJidWNrZXRjaGFydGEvYWxleC1wZXJmaWwuanBlZyIsInRyYW5zZm9ybWF0aW9ucyI6IiIsImlhdCI6MTY3MDM2MDY1NSwiZXhwIjoxOTg1NzIwNjU1fQ.bdhNc9BTNrwiaojZg5ShR3AEUfjgebA9YdHB6MwuZqA&t=2022-12-06T21%3A04%3A14.815Z",
      "linkedIn": "https://www.linkedin.com/in/alexis-estrada-evangelista-a69224211/",
      "behance": null,
      "github": "https://github.com/alexestrd",
      "email": ""
  },
  {
    "id": 68,
    "nameComplete": "Cristian Aguirre",
    "role": "Backend Developer",
    "description": "Forma parte del equipo de back con java y spring boot",
    "image": "../../../assets/img/data participantes/1631314354289.jpg",
    "linkedIn": "https://www.linkedin.com/in/aguirre-cristian-javadeveloper/",
    "behance": null,
    "github": null,
    "email": null
},
  ]

  httpOptions : any    = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Allow-Methods': 'POST',
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private serviceAboudUS:AboudUSService) { }

  ngOnInit(): void {
    this.obtenerDatos;
  }

  scrollTo(seccion: string) {
    window.location.hash = '';
    window.location.hash = seccion;   
  }

  obtenerDatos(){
    this.serviceAboudUS.obtenerDatos().subscribe(
      data =>{
        console.log(data)
        console.log("Corriendo")
        this.listaParticipantes = data;
      },
      err => console.error(err)
    )
  }

}
