package com.state.state2;

import com.state.State;

import javax.ejb.Stateful;

@Stateful(name = "StatefulBean2") // name must be unique and since StatefulBean already exists, this one has to get another name
public class StatefulBean extends State {}
