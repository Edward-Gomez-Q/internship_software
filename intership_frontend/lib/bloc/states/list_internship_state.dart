import 'package:intership_frontend/bloc/states/intership_state.dart';

class ListInternshipState {
  final List<IntershipState> internships;
  ListInternshipState(
      List<IntershipState> newInternships, {
        List<IntershipState>? internships,
      }) : internships = newInternships;
}