import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';

class WrapperViewIntershipStudent extends StatelessWidget {
  final List<IntershipState> interships;

  WrapperViewIntershipStudent({Key? key, required this.interships})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView();
  }
}
