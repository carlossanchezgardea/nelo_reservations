-- INSERT INTO diner_user (uuid, first_name, last_name, created_at)
-- VALUES ('4ecde5e1-56a7-4d03-999e-096e9df64f08', 'Daniel', 'Rodriguez', CURRENT_TIMESTAMP),
--        ('6b72fbc5-88d3-46a7-bf7a-cac7b8aeb7c3', 'Nelson', 'Gonzalez', CURRENT_TIMESTAMP),
--        ('902ab832-ea7a-4b04-8f02-ecca7a650eac', 'Tomas', 'Marino', CURRENT_TIMESTAMP),
--        ('c0f08e47-9d6d-4bb3-9648-e5a2c7fc87bc', 'Roberto', 'Carroz', CURRENT_TIMESTAMP),
--        ('f1a6cf78-7d0b-47e1-8c59-a491a651f6ef', 'Alberto', 'Castro', CURRENT_TIMESTAMP);

-- INSERT INTO dietary_restrictions (uuid, restriction, diner_user_uuid, created_at)
-- VALUES ('0e78a68c-b5a1-4c5c-b513-1c2054e5a0dc', 'VEGAN', '4ecde5e1-56a7-4d03-999e-096e9df64f08', CURRENT_TIMESTAMP);
--
-- INSERT INTO dietary_restrictions (uuid, restriction, diner_user_uuid, created_at)
-- VALUES ('8683865d-7f89-4b36-92bb-8f32598f28d4', 'GLUTENFREE', '6b72fbc5-88d3-46a7-bf7a-cac7b8aeb7c3',
--         CURRENT_TIMESTAMP),
--        ('62dc059b-ecab-418a-8c36-d874452fab47', 'DAIRYFREE', '6b72fbc5-88d3-46a7-bf7a-cac7b8aeb7c3', CURRENT_TIMESTAMP);
--
-- INSERT INTO dietary_restrictions (uuid, restriction, diner_user_uuid, created_at)
-- VALUES ('b11142d4-d8bf-464e-96b0-336a9b092de3', 'KETO', '902ab832-ea7a-4b04-8f02-ecca7a650eac', CURRENT_TIMESTAMP),
--        ('4f8b01c1-ee50-4e38-81fa-c0c958f49b54', 'PALEO', '902ab832-ea7a-4b04-8f02-ecca7a650eac', CURRENT_TIMESTAMP);
--
-- INSERT INTO restaurant (uuid, name, created_at)
-- VALUES ('66c6b0ff-62f9-441f-8485-250bc8ab5ed7', 'GreenSprout', CURRENT_TIMESTAMP),
--        ('f13a0f69-75f8-45ed-b1a7-4a2c831a1aef', 'HealthyChoice', CURRENT_TIMESTAMP),
--        ('bcf678d7-43a8-4dda-970c-907d8e8d5e42', 'SeaHarvest', CURRENT_TIMESTAMP),
--        ('454c84d4-afeb-4d5b-9e81-ed88e5cc3e38', 'PastaParadise', CURRENT_TIMESTAMP),
--        ('533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', 'SweetVegan', CURRENT_TIMESTAMP),
--        ('4ec51110-dde0-405a-97f7-8ce8b149be72', 'BarbequeNation', CURRENT_TIMESTAMP),
--        ('9dd34ecd-c5b6-4ea1-8265-bd967e53bffe', 'PaleoSpot', CURRENT_TIMESTAMP),
--        ('f423e699-4db9-45e6-aed4-5861cfc31874', 'GlutenFreeBakery', CURRENT_TIMESTAMP),
--        ('b48affba-0367-4120-ada9-1ff254f07a11', 'HalalHouse', CURRENT_TIMESTAMP),
--        ('f1fe572d-93ff-4a00-9d5c-abb244af36f1', 'KosherKorner', CURRENT_TIMESTAMP);

-- INSERT INTO dietary_endorsements (uuid, endorsement, restaurant_uuid, created_at, updated_at)
-- VALUES
--     ('20de8f11-5d80-4e05-b00b-6705ada7fa95', 'VEGAN', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('015656c1-49a2-4ca6-879e-cfff765f64f7', 'VEGETARIAN', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('91ca1331-2096-4541-9332-ec84af528da9', 'GLUTENFREE', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('bf8708e2-d3dc-4154-87cb-52f66ab29ae2', 'DAIRYFREE', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('eb882823-e27c-44e5-a783-273d8a1cae88', 'NUTFREE', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('e07eb017-640e-4464-b9fb-d502251dfa39', 'HALAL', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('6ae40b02-ff0b-4768-9997-461e35c19ef6', 'KOSHER', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('8fff2577-4d77-459f-ba67-dbeade10fbf5', 'LOWCARB', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('74b45287-4977-4d96-97dd-7e2546d52c3f', 'KETO', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('ae77bfad-0e46-493f-8b1e-4199522dc7a1', 'PALEO', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('9b47e6b9-5033-4185-a665-02876cea009d', 'PESCATARIAN', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('e1af26aa-64d9-4688-a7ec-11afe225097f', 'LOWFAT', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL),
--     ('84b77d48-d2be-4147-bb95-43b5c9e7e35c', 'DIABETIC', '533ec0e6-1ec4-4d4e-93bb-d29bf04a62c3', CURRENT_TIMESTAMP, NULL);

-- -- Restaurant: GreenSprout
-- INSERT INTO dietary_endorsements (uuid, endorsement, restaurant_uuid, created_at, updated_at)
-- VALUES
--     ('58dd8b76-fecc-424f-960f-b2817f66d59b', 'VEGETARIAN', '66c6b0ff-62f9-441f-8485-250bc8ab5ed7', CURRENT_TIMESTAMP, NULL);
--
-- -- Restaurant: HealthyChoice
-- INSERT INTO dietary_endorsements (uuid, endorsement, restaurant_uuid, created_at, updated_at)
-- VALUES
--     ('c1a4ba2e-f0fa-4ecc-bf23-3bbd68bed6c2', 'LOWCARB', 'f13a0f69-75f8-45ed-b1a7-4a2c831a1aef', CURRENT_TIMESTAMP, NULL),
--     ('5f47ff29-610c-411e-9928-0e2033af9808', 'DIABETIC', 'f13a0f69-75f8-45ed-b1a7-4a2c831a1aef', CURRENT_TIMESTAMP, NULL);
--
-- -- Restaurant: SeaHarvest
-- INSERT INTO dietary_endorsements (uuid, endorsement, restaurant_uuid, created_at, updated_at)
-- VALUES
--     ('b6775055-d407-4e43-a731-690a1cc618d2', 'PESCATARIAN', 'bcf678d7-43a8-4dda-970c-907d8e8d5e42', CURRENT_TIMESTAMP, NULL);
--
-- -- Restaurant: PastaParadise
-- INSERT INTO dietary_endorsements (uuid, endorsement, restaurant_uuid, created_at, updated_at)
-- VALUES
--     ('09e884b6-5991-4c53-a973-1777697cae4f', 'GLUTENFREE', '454c84d4-afeb-4d5b-9e81-ed88e5cc3e38', CURRENT_TIMESTAMP, NULL),
--     ('eef2679d-55d6-49a0-b516-05aa89517a0c', 'VEGAN', '454c84d4-afeb-4d5b-9e81-ed88e5cc3e38', CURRENT_TIMESTAMP, NULL);
--
-- -- Restaurant: BarbequeNation
-- INSERT INTO dietary_endorsements (uuid, endorsement, restaurant_uuid, created_at, updated_at)
-- VALUES
--     ('b6d2c828-d8fe-456b-924c-3c0742e84395', 'HALAL', '4ec51110-dde0-405a-97f7-8ce8b149be72', CURRENT_TIMESTAMP, NULL),
--     ('343ec885-7a13-4f93-8bfe-7b60643a9963', 'KETO', '4ec51110-dde0-405a-97f7-8ce8b149be72', CURRENT_TIMESTAMP, NULL),
--     ('116ce260-0731-4a27-b357-2471712f0902', 'PALEO', '4ec51110-dde0-405a-97f7-8ce8b149be72', CURRENT_TIMESTAMP, NULL);