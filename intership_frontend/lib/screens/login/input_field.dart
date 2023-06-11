import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/components/password.dart';

import '../../bloc/cubit/auth_cubit.dart';
import '../../bloc/states/auth_state.dart';

class InputField extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    bool _obscureText = true;
    return BlocBuilder<AuthCubit, AuthState>(builder: (context, state){
      return SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Container(
              padding: EdgeInsets.all(10),
              child: TextField(
                decoration: InputDecoration(
                  hintText: 'Ingresa tu correo electrónico',
                  hintStyle: TextStyle(color: Colors.grey),
                  icon: Icon(Icons.email),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                  contentPadding: EdgeInsets.symmetric(vertical: 15),
                ),
                onChanged: (value) => context.read<AuthCubit>().updateEmail(value),
              ),
            ),
            Container(
              padding: EdgeInsets.all(10),
              child: Container(
                padding: EdgeInsets.all(10),
                child: TextField(
                  decoration: InputDecoration(
                    hintText: 'Ingresa tu contraseña',
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.lock),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                    contentPadding: EdgeInsets.symmetric(vertical: 15),
                  ),
                  obscureText: _obscureText,
                  onChanged: (value) => context.read<AuthCubit>().updatePassword(value),
                ),
              ),
            ),
          ],
        ),
      );
    });
  }
}
