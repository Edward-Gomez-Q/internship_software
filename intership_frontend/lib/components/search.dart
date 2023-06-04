import 'package:flutter/material.dart';

class SearchBar extends StatefulWidget {
  final Function(String) onSearch;
  final String hinttext;

  SearchBar({Key? key, required this.onSearch, required this.hinttext})
      : super(key: key);

  @override
  _SearchBarState createState() => _SearchBarState();
}

class _SearchBarState extends State<SearchBar> {
  TextEditingController _searchController = TextEditingController();

  @override
  void dispose() {
    _searchController.dispose();
    super.dispose();
  }

  void _handleSearch(String value) {
    widget.onSearch(value);
  }

  @override
  Widget build(BuildContext context) {
    return TextField(
      controller: _searchController,
      onChanged: _handleSearch,
      decoration: InputDecoration(
        hintText: widget.hinttext,
        prefixIcon: Icon(Icons.search),
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(20),
        ),
      ),
    );
  }
}
