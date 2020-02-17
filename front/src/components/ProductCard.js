import React from 'react';
import '../assets/ProductCard.css';
import { Card } from "antd";

const { Meta } = Card;

const ProductCard = ({ product }) => (
  <Card className="Card">
    <Meta
      title={product.name}
      description={product.description}
    />
    {product.price &&
      product.price + ' $'
    }
  </Card>
);

export default ProductCard;