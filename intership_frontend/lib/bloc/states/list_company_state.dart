import 'package:intership_frontend/bloc/states/company_state.dart';

class ListCompanyState {
  final List<CompanyState> companies;
  ListCompanyState(
    List<CompanyState> newCompanies, {
    List<CompanyState>? companies,
  }) : companies = newCompanies;
}
