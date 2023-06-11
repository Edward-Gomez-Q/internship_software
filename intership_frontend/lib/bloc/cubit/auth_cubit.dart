import 'package:intership_frontend/bloc/states/token_state.dart';

import '../../services/auth_services.dart';
import '../states/auth_state.dart';
import 'package:bloc/bloc.dart';


class AuthCubit extends Cubit<AuthState> {
  AuthCubit() : super(AuthState());
  //Update
  void update(AuthState auth) async {
    emit(auth);
  }
  void clear() async {
    emit(AuthState());
  }
  //Update email
  void updateEmail(String email) async {
    emit(state.copyWith(email: email));
  }
  //Update password
  void updatePassword(String password) async {
    emit(state.copyWith(password: password));
  }
  // Login
  Future<TokenState> login() async {
    try {
      final user = await AuthServices.login(state);
      emit(AuthState());
      return user;
    } catch (e) {
      emit(AuthState());
      return const TokenState(
        type: -1,
      );
    }
  }
  // Logout
  Future<void> logout() async {
    emit(AuthState());
  }


}