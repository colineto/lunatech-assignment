import React, { useCallback, useState } from 'react';
import '../assets/Filters.css';
import { sortBy, orderBy, defaultFilters} from "./constants";
import { Checkbox, Radio } from "antd";

const filters = defaultFilters;

const Filters = ({ updateFilters }) => {
  const [sort, setSort] = useState(sortBy[0]);
  const [order, setOrder] = useState(orderBy[0]);

  const setFilters = useCallback((name, value) =>{
    if(name === 'sort') setSort(value);
    if(name === 'order') setOrder(value);
    filters[name] = value;
    updateFilters(filters);
  }, [updateFilters]);

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
        {sortBy.map((f, idx) =>
          <Radio key={idx} value={f}> {f} </Radio>
        )}
      </Radio.Group>

      <Radio.Group
        className="Filter-radio"
        value={order}
        onChange={e => setFilters('order', e.target.value)}
      >
        <div className="Filter-content"> Order items by </div>
        {orderBy.map((o, idx) =>
          <Radio key={idx} value={o}> {o} </Radio>
        )}
      </Radio.Group>
    </div>
  );
};

export default Filters;
