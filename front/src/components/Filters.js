import React from 'react';
import '../assets/Filters.css';
import {Button, Cascader, Checkbox} from "antd";

const Filters = () => (
  <div className="Filters-wrapper">
    <Checkbox className="Filters">
      Already Assembled Products
    </Checkbox>
    <Button className="Filters">
      Order By
    </Button>
    <Button className="Filters">
      Filter By
    </Button>
  </div>
);

export default Filters;
