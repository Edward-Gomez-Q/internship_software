import 'package:flutter/material.dart';
import 'package:file_picker/file_picker.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/models/intership_model.dart';
import 'package:intership_frontend/screens/company/principal/wraper_careers.dart';
import 'package:intership_frontend/screens/company/select_career.dart';

import '../../../bloc/cubit/token_cubit.dart';

class WraperPostIntership2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<IntershipCubit, IntershipState>(
      builder: (context, state) {
        return BlocBuilder<TokenCubit,TokenState>(builder: (context, tokenState) {
          return Padding(
            padding: EdgeInsets.all(20),
            child: SingleChildScrollView(
              child: Column(
                children: <Widget>[
                  Row(
                    children: [
                      Text('Descripción detallada',
                          style: TextStyle(
                              fontSize: 20, color: Colors.grey.shade600),
                          textAlign: TextAlign.left),
                      SizedBox(
                        width: 20,
                      ),
                      ElevatedButton(
                        onPressed: () async {
                          FilePickerResult? result =
                          await FilePicker.platform.pickFiles();
                          if (result != null) {
                            PlatformFile file = result.files.first;
                            String url = file.path.toString();
                            BlocProvider.of<IntershipCubit>(context)
                                .updateUrlPDF(url);
                          } else {
                            showDialog(
                              context: context,
                              builder: (BuildContext context) {
                                return AlertDialog(
                                  title: Text('Error'),
                                  content: Text('No se pudo cargar el archivo'),
                                  actions: [
                                    TextButton(
                                      onPressed: () {
                                        Navigator.of(context).pop();
                                      },
                                      child: Text('Ok'),
                                    )
                                  ],
                                );
                              },
                            );
                          }
                        },
                        child: Text('Cargar PDF'),
                        style: ElevatedButton.styleFrom(
                          primary: Color.fromARGB(255, 9, 123, 16),
                          onPrimary: Colors.white,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    children: [
                      Text('Silabo de hoja de vida',
                          style: TextStyle(
                              fontSize: 20, color: Colors.grey.shade600),
                          textAlign: TextAlign.left),
                      SizedBox(
                        width: 20,
                      ),
                      ElevatedButton(
                        onPressed: () async {
                          FilePickerResult? result =
                          await FilePicker.platform.pickFiles();
                          if (result != null) {
                            PlatformFile file = result.files.first;
                            String url = file.path.toString();
                            BlocProvider.of<IntershipCubit>(context)
                                .updateUrlWORD(url);
                          } else {
                            AlertDialog(
                              title: Text('Error'),
                              content: Text('No se pudo cargar el archivo'),
                              actions: [
                                TextButton(
                                  onPressed: () {
                                    Navigator.of(context).pop();
                                  },
                                  child: Text('Ok'),
                                )
                              ],
                            );
                          }
                        },
                        child: Text('Cargar WORD'),
                        style: ElevatedButton.styleFrom(
                          primary: Color.fromARGB(255, 9, 123, 16),
                          onPrimary: Colors.white,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    children: [
                      Text('Formación del pasante',
                          style: TextStyle(
                              fontSize: 20, color: Colors.grey.shade600),
                          textAlign: TextAlign.left),
                      SizedBox(
                        width: 20,
                      ),
                      ElevatedButton(
                        onPressed: () {
                          Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => SelectCareer()));
                        },
                        child: Text("Seleccionar"),
                        style: ElevatedButton.styleFrom(
                          primary: Colors.blue.shade900,
                          onPrimary: Colors.white,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: "Requisitos",
                      hintStyle: TextStyle(color: Colors.grey),
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                    ),
                    onChanged: (value) {
                      BlocProvider.of<IntershipCubit>(context)
                          .updateRequisitos(value);
                    },
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  ElevatedButton(
                    onPressed: () {
                      showDialog(
                        context: context,
                        builder: (BuildContext context) {
                          return AlertDialog(
                            title: Text('¿Esta seguro de publicar la pasantía?'),
                            content: Text(
                                'Ha completado el formulario de publicación de pasantía.'),
                            actions: [
                              TextButton(
                                child: Text('Cancelar'),
                                onPressed: () {
                                  Navigator.of(context).pop();
                                },
                              ),
                              TextButton(
                                child: Text('Publicar'),
                                onPressed: () {
                                  IntershipModel intership = IntershipModel(
                                    department: state.departamento,
                                    deadline: state.fechaLimite,
                                    days: state.dias.toString(),
                                    description: state.descripcion,
                                    careers: state.listaCarreras,
                                    duration: 0,
                                    endDate: state.fechaLimite,
                                    knowledge: state.requisitos,
                                    startDate: state.horaInicio,
                                    title: state.titulo,
                                    urlPDF: state.urlPDF,
                                    urlWord: state.urlwORD,
                                  );
                                  BlocProvider.of<IntershipCubit>(context).registerIntership(tokenState.authToken,tokenState.id,intership);

                                },
                              ),
                            ],
                          );
                        },
                      );
                    },
                    child: Text("Publicar"),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.blue.shade900,
                      onPrimary: Colors.white,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          );

        },);
      },
    );
  }
}
