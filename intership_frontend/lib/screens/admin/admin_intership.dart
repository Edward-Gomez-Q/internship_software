import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/list_internship_cubit.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'package:intership_frontend/bloc/states/list_internship_state.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/components/bottombar_admincom.dart';
import 'package:intership_frontend/screens/admin/principal/wraper_intership.dart';

import '../../bloc/states/intership_state.dart';

class AdminIntership extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<TokenCubit,TokenState>(builder: (context, tokenState) {
      BlocProvider.of<ListInternshipCubit>(context).clearList();
      BlocProvider.of<ListInternshipCubit>(context).getAllInternshipsWaiting(tokenState.authToken, tokenState.id);
      return BlocBuilder<ListInternshipCubit,ListInternshipState>(builder: (context, state) {
        return Scaffold(
          appBar: MyAppBar(title: 'Aprobación Pasantías'),
          body: Container(
            child: WraperAdminIntership(
              interships: state.internships,
              tokenState: tokenState,
            ),
          ),
          bottomNavigationBar: BottomBarAdmin(),
        );
      },);
    },);
  }
}
