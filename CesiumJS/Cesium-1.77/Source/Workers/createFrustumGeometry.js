/* This file is automatically rebuilt by the Cesium build process. */
define(['./when-e6985d2a', './Check-24cae389', './Math-1e296fbe', './Cartesian2-a27b2f0f', './Transforms-5b19d5c9', './RuntimeError-61701d3e', './WebGLConstants-34c08bc0', './ComponentDatatype-cb08e294', './GeometryAttribute-776e3526', './GeometryAttributes-d6ea8c2b', './Plane-98aa9658', './VertexFormat-2df57ea4', './FrustumGeometry-2170d60a'], function (when, Check, _Math, Cartesian2, Transforms, RuntimeError, WebGLConstants, ComponentDatatype, GeometryAttribute, GeometryAttributes, Plane, VertexFormat, FrustumGeometry) { 'use strict';

  function createFrustumGeometry(frustumGeometry, offset) {
    if (when.defined(offset)) {
      frustumGeometry = FrustumGeometry.FrustumGeometry.unpack(frustumGeometry, offset);
    }
    return FrustumGeometry.FrustumGeometry.createGeometry(frustumGeometry);
  }

  return createFrustumGeometry;

});
