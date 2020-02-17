import React, {useEffect, useState} from 'react';
import '../assets/App.css';
import axios from 'axios';
import ProductCard from "./ProductCard";
import Filters from "./Filters";

const App = () => {
  const [data, setData] = useState([]);
  useEffect( () => {
    async function fetchData() {
      const response = await axios('http://localhost:9000/products');
      if(response.status === 200) setData(response.data);
    }
    fetchData()
  }, []);

  return(
    <div className="App">
      <header className="App-header">
        LunaFactory Furniture
      </header>
      <div className="App-wrapper">
        <div className="App-filters">
          <Filters />
        </div>
        <div className="App-cards">
          {data.map(product =>
            <ProductCard product={product} />
          )}
        </div>
      </div>
    </div>
  );
};

export default App;
