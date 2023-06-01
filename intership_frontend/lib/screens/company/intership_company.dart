import 'package:flutter/material.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/search.dart';

class HomeCompany extends StatelessWidget {
  void handleSearch(String value) {
    print(value);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Padding(
            padding: EdgeInsets.only(top: 40),
            child: Container(
              padding: EdgeInsets.symmetric(horizontal: 20),
              child: SearchBar(
                onSearch: handleSearch,
              ),
            ),
          ),
          SizedBox(
            height: 20,
          ),
          Text("Pasantías activas",
              style: TextStyle(fontSize: 20, color: Colors.grey.shade600)),
          SizedBox(
            height: 20,
          ),
        ],
      ),
      bottomNavigationBar: BottomBarCompany(),
    );
  }
}
