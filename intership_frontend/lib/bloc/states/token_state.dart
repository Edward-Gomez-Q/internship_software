//Terminado
import 'package:equatable/equatable.dart';
import 'package:flutter/src/widgets/framework.dart';

class TokenState extends Equatable {
  final String authToken;
  final String refreshToken;
  final int type;
  final int id;

  const TokenState({this.authToken = "", this.refreshToken = "", this.type = 0, this.id = 0});

  //Map
  factory TokenState.fromMap(Map tokenMap) {
    return TokenState(
      authToken: tokenMap["response"]['authToken'],
      refreshToken: tokenMap["response"]['refreshToken'],
      type: tokenMap["response"]['type'],
      id: tokenMap["response"]['id'],
    );
  }

  @override
  // TODO: implement props
  List<Object?> get props => [authToken, refreshToken, type, id];

  Widget when(
      {required Widget Function(TokenState) initial,
        required Widget Function(TokenState) authenticated,
        required Widget Function(TokenState) unauthenticated}) {
    throw UnimplementedError();
  }
}