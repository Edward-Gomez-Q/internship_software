import 'package:flutter/material.dart';

import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/auth_cubit.dart';
import 'package:intership_frontend/bloc/cubit/company_cubit.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/screens/admin/admin_company.dart';
import 'package:intership_frontend/screens/company/intership_company.dart';
import 'package:intership_frontend/screens/registration/registration_principal.dart';
import 'package:intership_frontend/screens/student/student_intership.dart';
import '../../bloc/cubit/list_internship_cubit.dart';
import '../../bloc/states/auth_state.dart';
import '../company/message.dart';
import 'input_field.dart';

class Wrapper extends StatelessWidget {
  Wrapper({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<AuthCubit, AuthState>(builder: (context, state) {
      return BlocBuilder<TokenCubit, TokenState>(
        builder: (context, tokenState) {
          return Padding(
            padding: EdgeInsets.all(30),
            child: SingleChildScrollView(
              child: Column(
                children: <Widget>[
                  const SizedBox(
                    height: 40,
                  ),
                  Container(
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: InputField(),
                  ),
                  const SizedBox(
                    height: 40,
                  ),
                  TextButton(
                    onPressed: () {
                      Navigator.push(context,
                          MaterialPageRoute(builder: (context) {
                        return Registration();
                      }));
                    },
                    child: Text(
                      "Regístrate",
                      style: TextStyle(color: Colors.grey),
                    ),
                  ),
                  SizedBox(
                    height: 40,
                  ),
                  ElevatedButton(
                    onPressed: () async {
                      Future<TokenState> token =
                          BlocProvider.of<AuthCubit>(context).login();
                      token.then((value) {
                        if (value.type == -1) {
                          //Login Fallido

                        } else if (value.type == 1) {
                          BlocProvider.of<TokenCubit>(context).login(value);
                          //Login Estudiante
                          Navigator.push(context,
                              MaterialPageRoute(builder: (context) {
                                return HomeStudent();
                              }));
                        } else if (value.type == 2) {
                          //Saber si fue aprobado
                          BlocProvider.of<TokenCubit>(context).login(value);
                          Future<bool> aceppted = BlocProvider.of<CompanyCubit>(context).isRegistered(tokenState.authToken, tokenState.id);
                          aceppted.then((value) {
                            if(value){
                              Navigator.push(context,
                                  MaterialPageRoute(builder: (context) {
                                    return HomeCompany();
                                  }));
                            }else{
                              Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                      builder: (context) => Message()));
                            }
                          });
                        } else if (value.type == 3){
                          BlocProvider.of<TokenCubit>(context).login(value);
                          //Login Administrador
                          Navigator.push(context,
                              MaterialPageRoute(builder: (context) {
                                return AdminCompany();
                              }));
                        }
                      });
                    },
                    child: Text("Iniciar sesion"),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.blue.shade900,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          );
        },
      );
    });
  }
}
