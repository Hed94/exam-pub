-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Stř 04. bře 2020, 00:55
-- Verze serveru: 10.4.8-MariaDB
-- Verze PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `tavern`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `ordered_products`
--

CREATE TABLE `ordered_products` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `ordered_products`
--

INSERT INTO `ordered_products` (`id`, `amount`, `product_id`, `user_id`) VALUES
(1, 10, 2, 1),
(2, 3, 1, 1),
(5, 1, 1, 2),
(6, 5, 1, 2);

-- --------------------------------------------------------

--
-- Struktura tabulky `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `price` int(11) NOT NULL,
  `product_name` varchar(255) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  `is_for_adult` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `product`
--

INSERT INTO `product` (`id`, `price`, `product_name`, `is_for_adult`) VALUES
(1, 75, 'Finlandia vodka', 1),
(2, 90, 'Russian standart', 1);

-- --------------------------------------------------------

--
-- Struktura tabulky `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  `pocket` int(11) NOT NULL,
  `is_adult` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `user`
--

INSERT INTO `user` (`id`, `is_active`, `name`, `pocket`, `is_adult`) VALUES
(1, b'1', 'Test Testovič', 250, b'1'),
(2, b'1', 'Donald Trump', 999550, b'1'),
(3, b'0', 'Vladimir Putin', 679925, b'0');

--
-- Klíče pro exportované tabulky
--

--
-- Klíče pro tabulku `ordered_products`
--
ALTER TABLE `ordered_products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2f6inikj5isd8v7kv37auv0s9` (`product_id`),
  ADD KEY `FKkp1ju4hchfgkak4mjojebcmn4` (`user_id`);

--
-- Klíče pro tabulku `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Klíče pro tabulku `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `ordered_products`
--
ALTER TABLE `ordered_products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pro tabulku `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pro tabulku `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `ordered_products`
--
ALTER TABLE `ordered_products`
  ADD CONSTRAINT `FK2f6inikj5isd8v7kv37auv0s9` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKkp1ju4hchfgkak4mjojebcmn4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
