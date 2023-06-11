import 'package:equatable/equatable.dart';

class CompanyModel extends Equatable{
  final String nameCompany;
  final List<String> sectors;
  final String review;
  final String urlLogo;
  final String webSide;
  final String nit;
  final String Names;
  final String firstLastName;
  final String secondLastName;
  final String email;
  final String password;
  final String phone;
  CompanyModel({
    this.nameCompany = '',
    this.sectors = const [],
    this.review = '',
    this.urlLogo = '',
    this.webSide = '',
    this.nit = '',
    this.Names = '',
    this.firstLastName = '',
    this.secondLastName = '',
    this.email = '',
    this.password = '',
    this.phone = '',
  });
  CompanyModel copyWith({
    String? nameCompany,
    List<String>? sectors,
    String? review,
    String? urlLogo,
    String? webSide,
    String? nit,
    String? Names,
    String? firstLastName,
    String? secondLastName,
    String? email,
    String? password,
    String? phone,
  }) {
    return CompanyModel(
      nameCompany: nameCompany ?? this.nameCompany,
      sectors: sectors ?? this.sectors,
      review: review ?? this.review,
      urlLogo: urlLogo ?? this.urlLogo,
      webSide: webSide ?? this.webSide,
      nit: nit ?? this.nit,
      Names: Names ?? this.Names,
      firstLastName: firstLastName ?? this.firstLastName,
      secondLastName: secondLastName ?? this.secondLastName,
      email: email ?? this.email,
      password: password ?? this.password,
      phone: phone ?? this.phone,
    );
  }
  Map<String, dynamic> toMap() {
    return {
      'nameCompany': nameCompany,
      'sectors': sectors,
      'review': review,
      'urlLogo': urlLogo,
      'webSide': webSide,
      'nit': nit,
      'Names': Names,
      'firstLastName': firstLastName,
      'secondLastName': secondLastName,
      'email': email,
      'password': password,
      'phone': phone,
    };
  }

  @override
  // TODO: implement props
  List<Object?> get props => [
    nameCompany,
    sectors,
    review,
    urlLogo,
    webSide,
    nit,
    Names,
    firstLastName,
    secondLastName,
    email,
    password,
    phone,
  ];
}