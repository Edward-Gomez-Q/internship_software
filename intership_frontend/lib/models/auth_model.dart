class LoginModel{
  final String email;
  final String password;
  LoginModel({
    this.email = '',
    this.password = '',
  });
LoginModel copyWith({
    String? email,
    String? password,
  }) {
    return LoginModel(
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
  factory LoginModel.fromMap(Map<String, dynamic> map) {
    return LoginModel(
      email: map['email'],
      password: map['password'],
    );
  }
  static LoginModel fromJson(item) {
    return LoginModel(
      email: item['email'],
      password: item['password'],
    );
  }
}