import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/list_internship_cubit.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'package:intership_frontend/bloc/states/list_internship_state.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/bottombar_student.dart';
import 'package:intership_frontend/components/search.dart';
import 'package:intership_frontend/screens/company/principal/wraper_view_intership.dart';
import 'package:intership_frontend/screens/student/principal_student/wraper_interships.dart';

import '../../bloc/states/intership_state.dart';

class HomeStudent extends StatelessWidget {
  void handleSearch(String value) {
    print(value);
  }

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<TokenCubit,TokenState>(builder: (context, tokenState) {
      //Borrar todos los internships
      BlocProvider.of<ListInternshipCubit>(context).clearList();
      //Obtener todos los internships
      BlocProvider.of<ListInternshipCubit>(context).getAllInternshipsAvailable(tokenState.authToken, tokenState.id);
      return BlocBuilder<ListInternshipCubit,ListInternshipState>(builder: (context, state) {
        return Scaffold(
          appBar: MyAppBar(title: "Pasantías Activas"),
          body: Column(
            children: [
              /*Padding(
            padding: EdgeInsets.only(top: 40),
            child: Container(
              padding: EdgeInsets.symmetric(horizontal: 20),
              child: SearchBar(
                hinttext: 'Buscar por nombre',
                onSearch: handleSearch,
              ),
            ),
          ),*/
              SizedBox(
                height: 20,
              ),
              Expanded(
                child: WrapperViewIntershipStudent(
                  interships:state.internships,
                ),
              ),
            ],
          ),
          bottomNavigationBar: BottomBarStudent(),
        );
      },);
    },);
  }
}
