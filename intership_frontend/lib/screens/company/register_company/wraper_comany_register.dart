import 'package:file_picker/file_picker.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/company_cubit.dart';
import 'package:intership_frontend/screens/company/company_register2.dart';
import 'package:intership_frontend/screens/company/intership_company.dart';
import 'package:intership_frontend/screens/registration/registration_principal.dart';
import 'package:intership_frontend/services/globals.dart';
import '../../../bloc/states/company_state.dart';

class WrapperRegisterCompany extends StatelessWidget {
  final _keyform;
  WrapperRegisterCompany({Key? key})
      : _keyform = GlobalKey<FormState>(),
        super(key: key);
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<CompanyCubit, CompanyState>(
      builder: (context, state) {
        return Padding(
          padding: EdgeInsets.all(30),
          child: SingleChildScrollView(
            child: Form(
                key: _keyform,
                child: Column(children: <Widget>[
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: 'Nombre de la empresa',
                      hintStyle: TextStyle(color: Colors.grey),
                      icon: Icon(Icons.work),
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(20),
                      ),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Este campo es obligatorio';
                      }
                      if (value.length >= 100) {
                        return 'Este campo no puede tener mas de 100 caracteres';
                      }
                    },
                    onChanged: (value) {
                      BlocProvider.of<CompanyCubit>(context)
                          .updateNombreEmpresa(value);
                    },
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Align(
                    alignment: Alignment.centerRight,
                    child: TextFormField(
                      decoration: InputDecoration(
                        hintText: 'Reseña de la compañia',
                        hintStyle: TextStyle(color: Colors.grey),
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                      ),
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return 'Este campo es obligatorio';
                        }
                      },
                      onChanged: (value) {
                        BlocProvider.of<CompanyCubit>(context)
                            .updateResena(value);
                      },
                    ),
                  ),
                  /*SizedBox(
                    height: 20,
                  ),
                  Row(children: <Widget>[
                    Text("Logo de la empresa",
                        style: TextStyle(fontSize: 15, color: Colors.grey)),
                    SizedBox(
                      height: 20,
                    ),
                    ElevatedButton(
                      onPressed: () async {
                        FilePickerResult? result =
                            await FilePicker.platform.pickFiles();
                        if (result != null) {
                          PlatformFile file = result.files.first;
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
                      child: Text("Cargar imagen"),
                      style: ElevatedButton.styleFrom(
                        primary: Color.fromARGB(255, 9, 123, 16),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10),
                        ),
                      ),
                    ),
                  ]),*/
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: 'Sitio web de la empresa',
                      hintStyle: TextStyle(color: Colors.grey),
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(20),
                      ),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Este campo es obligatorio';
                      }
                    },
                    onChanged: (value) => BlocProvider.of<CompanyCubit>(context)
                        .updateSitioWeb(value),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: 'NIT',
                      hintStyle: TextStyle(color: Colors.grey),
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(20),
                      ),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Este campo es obligatorio';
                      }
                    },
                    onChanged: (value) =>
                        BlocProvider.of<CompanyCubit>(context).updateNit(value),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    children: [
                      ElevatedButton(
                        child: Text("Atras"),
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => Registration()),
                          );
                        },
                        style: ElevatedButton.styleFrom(
                          primary: Colors.red.shade900,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(20),
                          ),
                        ),
                      ),
                      SizedBox(
                        width: 20,
                      ),
                      ElevatedButton(
                        child: Text("Siguiente"),
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => RegisterCompany2()),
                          );
                        },
                        style: ElevatedButton.styleFrom(
                          primary: Colors.blue.shade900,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(20),
                          ),
                        ),
                      ),
                    ],
                  ),
                ])),
          ),
        );
      },
    );
  }
}
