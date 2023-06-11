import 'package:file_picker/file_picker.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/student_cubit.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/bottombar_student.dart';
import 'package:intership_frontend/components/calendar_button.dart';
import 'package:intership_frontend/main.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post_intership.dart';
import 'package:intership_frontend/screens/student/principal_student/wraper_postulation.dart';

import '../../bloc/cubit/list_internship_cubit.dart';
import '../../components/appbar.dart';

class Postulation extends StatelessWidget {
  final IntershipState intership;
  Postulation({Key? key, required this.intership}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<TokenCubit,TokenState>(builder: (context, tokenState) {
      return Scaffold(
        appBar: MyAppBar(title: "Postulación"),
        body: Column(
          children: [
            Padding(
              padding: EdgeInsets.only(top: 45),
              child: Align(
                alignment: Alignment.topCenter,
                child: Text(
                  "Ver pasantía",
                  style: TextStyle(fontSize: 25, color: Colors.grey.shade600),
                ),
              ),
            ),
            SizedBox(
              height: 20,
            ),
            Expanded(
                child: SingleChildScrollView(
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
                            Expanded(
                              child: Text(
                                intership.titulo,
                                style: TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                    color: Colors.grey.shade600),
                              ),
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
                            Expanded(
                              child: Text(
                                intership.carrera,
                                style: TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                    color: Colors.grey.shade600),
                              ),
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
                            Expanded(
                              child: Text(
                                intership.requisitos,
                                style: TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                    color: Colors.grey.shade600),
                              ),
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
                            Expanded(
                              child: Text(
                                intership.fechaLimite.toString(),
                                style: TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                    color: Colors.grey.shade600),
                              ),
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
                          Expanded(
                              child: Text(
                                intership.requisitos.toString(),
                                style: TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                    color: Colors.grey.shade600),
                              )),
                        ]),
                        Row(
                          children: [
                            ElevatedButton(
                                onPressed: () {},
                                child: Text("Descargar CV"),
                                style: ElevatedButton.styleFrom(
                                  primary: Colors.blue.shade900,
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(20),
                                  ),
                                )),
                            SizedBox(width: 20),
                            ElevatedButton(
                                onPressed: () async {
                                  FilePickerResult? result =
                                  await FilePicker.platform.pickFiles();
                                  if (result != null) {
                                    PlatformFile file = result.files.first;
                                  } else {
                                    AlertDialog(
                                      title: Text("Error"),
                                      content: Text("No se pudo cargar el archivo"),
                                      actions: [
                                        TextButton(
                                            onPressed: () {
                                              Navigator.pop(context);
                                            },
                                            child: Text("Aceptar")),
                                      ],
                                    );
                                  }
                                },
                                child: Text("Cargar CV"),
                                style: ElevatedButton.styleFrom(
                                  primary: Colors.green.shade900,
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(20),
                                  ),
                                )),
                            SizedBox(width: 20),
                            ElevatedButton(
                                onPressed: () {
                                  AlertDialog(
                                    title: Text("Postulación"),
                                    content: Text(
                                        "¿Está seguro que desea postularse a esta pasantía?"),
                                    actions: [
                                      TextButton(
                                          onPressed: () {
                                            Future<String> post=BlocProvider.of<StudentCubit>(context).postularsePasantia(tokenState.authToken, tokenState.id, intership.idInternship);
                                            post.then(
                                              (value) {
                                                if(value=='Ok')
                                                  {
                                                    //Borrar todos los internships
                                                    BlocProvider.of<ListInternshipCubit>(context).clearList();
                                                    //Obtener todos los internships
                                                    BlocProvider.of<ListInternshipCubit>(context).getAllInternshipsAvailable(tokenState.authToken, tokenState.id);

                                                  }
                                              }
                                            );
                                            Navigator.pop(context);
                                          },
                                          child: Text("Cancelar")),
                                      TextButton(
                                          onPressed: () {}, child: Text("Aceptar")),
                                    ],
                                  );
                                },
                                child: Text("Postular"),
                                style: ElevatedButton.styleFrom(
                                  primary: Colors.blue.shade900,
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(20),
                                  ),
                                )),
                          ],
                        ),
                      ],
                    ),
                  ),
                ))
          ],
        ),
      );
    },);
  }
}
