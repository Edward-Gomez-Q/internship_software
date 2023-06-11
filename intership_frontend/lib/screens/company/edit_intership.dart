import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post_intership.dart';

class EditIntership extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<TokenCubit, TokenState>(
      builder: (context, tpkenState) {
        return BlocBuilder<IntershipCubit, IntershipState>(
          builder: (context, interState) {
            return Scaffold(
              appBar: MyAppBar(title: "Editar pasantía"),
              body: Column(
                children: [
                  SizedBox(
                    height: 20,
                  ),
                  Expanded(
                    child: WraperPostIntership(),
                  )
                ],
              ),
            );
          },
        );
      },
    );
  }
}
