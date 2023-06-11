//Terminado
import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/auth_state.dart';

import '../../services/auth_services.dart';
import '../states/token_state.dart';


class TokenCubit extends Cubit<TokenState> {
  TokenCubit() : super(const TokenState());
  //Login
  void login(TokenState token) async {
    emit(token);
  }
}