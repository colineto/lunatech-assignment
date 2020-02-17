import React, {useCallback, useState} from 'react';
import '../assets/Filters.css';
import { Checkbox, Radio } from "antd";

const Filters = ({ updateFilters }) => {
  const filters = {'assembled': false, 'sort': 'price', 'order': 'asc'};
  const sorts = ['price', 'name'];
  const orders = ['asc', 'desc'];

  const [sort, setSort] = useState(sorts[0]);
  const [order, setOrder] = useState(orders[0]);

  const setFilters = useCallback((name, value) =>{
    if(name === 'sort') setSort(value);
    if(name === 'order') setOrder(value);
    filters[name] = value;
    updateFilters(filters);
  }, [filters, updateFilters]);

  return (
    <div className="Filters-wrapper">
      <Checkbox
        className="Filter-content"
        onChange={e => setFilters('assembled', e.target.checked)}
      >
        Already Assembled Items
      </Checkbox>

      <Radio.Group
        className="Filter-radio"
        value={sort}
        onChange={e => setFilters('sort', e.target.value)}
      >
        <div className="Filter-content"> Sort items by </div>
        {sorts.map(f =>
          <Radio value={f}> {f} </Radio>
        )}
      </Radio.Group>

      <Radio.Group
        className="Filter-radio"
        value={order}
        onChange={e => setFilters('order', e.target.value)}
      >
        <div className="Filter-content"> Order items by </div>
        {orders.map(o =>
          <Radio value={o}> {o} </Radio>
        )}
      </Radio.Group>
    </div>
  );
};

export default Filters;
