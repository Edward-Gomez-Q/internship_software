import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';

class WraperPostulation extends StatelessWidget {
  final IntershipState intership;
  WraperPostulation({Key? key, required this.intership}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Container(
        child: Column(
          children: [
            Row(
              children: [
                Text(
                  "Postulación: ",
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
                Text(
                  intership.titulo,
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
              ],
            ),
            Row(
              children: [
                Text(
                  "Carrera: ",
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
                Text(
                  intership.carrera,
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
              ],
            ),
            Row(
              children: [
                Text(
                  "Descripción: ",
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
                Text(
                  intership.requisitos,
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
              ],
            ),
            Row(
              children: [
                Text(
                  "Fecha límite: ",
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
                Text(
                  intership.fechaLimite.toString(),
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey.shade600),
                ),
              ],
            ),
            Row(children: [
              Text(
                "Requsitos: ",
                style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600),
              ),
              Text(
                intership.requisitos.toString(),
                style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600),
              )
            ])
          ],
        ),
      ),
    );
  }
}
