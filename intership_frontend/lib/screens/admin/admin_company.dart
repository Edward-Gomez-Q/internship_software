import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/list_company_cubit.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'package:intership_frontend/bloc/states/list_company_state.dart';
import 'package:intership_frontend/bloc/states/token_state.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/components/bottombar_admincom.dart';
import 'package:intership_frontend/screens/admin/principal/wraper_company.dart';

import '../../bloc/states/company_state.dart';

class AdminCompany extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<TokenCubit,TokenState>(builder: (context, tokenState) {
      BlocProvider.of<ListCompanyCubit>(context).clear();
      BlocProvider.of<ListCompanyCubit>(context).getAllCompanyWaiting(tokenState.authToken, tokenState.id);
      return BlocBuilder<ListCompanyCubit,ListCompanyState>(builder: (context, state) {
        return Scaffold(
          appBar: MyAppBar(title: 'Aprobación Empresas'),
          body: Container(
            child: WraperAdminCompany(company: state.companies,tokenState: tokenState),
          ),
          bottomNavigationBar: BottomBarAdmin(),
        );
      },);
    },);
  }
}
