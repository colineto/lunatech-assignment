import React, { useEffect, useState } from 'react';
import '../assets/App.css';
import axios from 'axios';
import ProductCard from "./ProductCard";
import Filters from "./Filters";
import { defaultFilters } from "./constants";

const App = () => {
  const [data, setData] = useState([]);
  const [filters, setFilters] = useState(defaultFilters);
  console.log(filters);

  useEffect( () => {
    const baseQuery = 'http://localhost:9000/products';
    const query = `${baseQuery}${filters.assembled ? '/assembled' : ''}?sort=${filters.sort}?order=${filters.order}`;
    console.log(query);
    async function fetchData() {
      console.log("fetch");
      const response = await axios(query);
      console.log(response.status);
      if(response.status === 200) setData(response.data);
    }
    fetchData()
  }, [filters, setFilters]);

  return(
    <div className="App">
      <header className="App-header">
        LunaFactory Furniture
      </header>
      <div className="App-wrapper">
        <Filters updateFilters={setFilters} />
        <div className="App-cards">
          {data.map(product =>
            <ProductCard key={product.id} product={product} />
          )}
        </div>
      </div>
    </div>
  );
};

export default App;
