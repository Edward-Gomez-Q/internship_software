import 'dart:convert';

import 'package:equatable/equatable.dart';

class CompanyModel extends Equatable {
  final int idCompany;
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
    this.idCompany = 0,
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
  factory CompanyModel.fromJson(Map<String, dynamic> json) {
    return CompanyModel(
      idCompany: json['idCompany'],
      nameCompany: json['nameCompany'],
      sectors: json['sectors'].cast<String>(),
      review: json['review'],
      urlLogo: json['urlLogo'],
      webSide: json['webSide'],
      nit: json['nit'],
      Names: json['Names'],
      firstLastName: json['firstLastName'],
      secondLastName: json['secondLastName'],
      email: json['email'],
      password: json['password'],
      phone: json['phone'],
    );
  }
  Map<String, dynamic> toJson() {
    return {
      'idCompany': idCompany,
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

  CompanyModel copyWith({
    int? idCompany,
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
      idCompany: idCompany ?? this.idCompany,
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
      'idCompany': idCompany,
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
        idCompany,
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
  static CompanyModel fromMap(Map<String, dynamic> map) {
    return CompanyModel(
      idCompany: map['idCompany'],
      nameCompany: map['nameCompany'],
      sectors: List<String>.from(map['sectors']),
      review: map['review'],
      urlLogo: map['urlLogo'],
      webSide: map['webSide'],
      nit: map['nit'],
      Names: map['Names'],
      firstLastName: map['firstLastName'],
      secondLastName: map['secondLastName'],
      email: map['email'],
      password: map['password'],
      phone: map['phone'],
    );
  }
}
