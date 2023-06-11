import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/search.dart';
import 'package:intership_frontend/screens/company/principal/wraper_view_intership.dart';

import '../../bloc/cubit/list_internship_cubit.dart';
import '../../bloc/states/intership_state.dart';
import '../../bloc/states/list_internship_state.dart';
import '../../components/appbar.dart';

class HomeCompany extends StatelessWidget {
  void handleSearch(String value) {
    print(value);
  }

  @override
  Widget build(BuildContext context) {

    return  BlocBuilder<TokenCubit,TokenState>(builder: (context, tokenState) {
        BlocProvider.of<ListInternshipCubit>(context).getAllInternships(tokenState.authToken,tokenState.id);
        return BlocBuilder<ListInternshipCubit,ListInternshipState>(builder: (context, state) {
          return Scaffold(
            appBar: MyAppBar(title: "Pasantías"),
            body: Column(
              children: [
                Padding(
                  padding: EdgeInsets.only(top: 40),
                  child: Container(
                    padding: EdgeInsets.symmetric(horizontal: 20),
                    child: SearchBar(
                      hinttext: 'Buscar por nombre',
                      onSearch: handleSearch,
                    ),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Text("Pasantías Activas",
                    style: TextStyle(fontSize: 30, color: Colors.blue.shade900)),
                SizedBox(
                  height: 20,
                ),
                Expanded(
                  child: WraperViewIntership(intershipState: state.internships),
                ),
              ],
            ),
            bottomNavigationBar: BottomBarCompany(),
          );
        },);
      },);
  }
}
