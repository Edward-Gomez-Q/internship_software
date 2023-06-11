import 'package:equatable/equatable.dart';

class AuthState extends Equatable{
  final String email;
  final String password;
  AuthState ({
    this.email = '',
    this.password = '',
  });
  AuthState copyWith({
    String? email,
    String? password,
  }) {
    return AuthState(
      email: email ?? this.email,
      password: password ?? this.password,
    );
  }
  Map<String, dynamic> toMap() {
    return {
      'email': email,
      'password': password,
    };
  }
  factory AuthState.fromMap(Map<String, dynamic> map) {
    return AuthState(
      email: map['email'],
      password: map['password'],
    );
  }
  static AuthState fromJson(item) {
    return AuthState(
      email: item['email'],
      password: item['password'],
    );
  }

  @override
  // TODO: implement props
  List<Object?> get props => [email, password];

}