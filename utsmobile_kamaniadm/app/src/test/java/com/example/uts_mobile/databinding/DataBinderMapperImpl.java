package com.example.uts_mobile.databinding;

import androidx.databinding.MergedDataBinderMapper;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.uts_mobile.DataBinderMapperImpl());
  }
}
